package com.example.skipper

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.annotation.SuppressLint
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

@SuppressLint("AccessibilityPolicy")
class SkipAdService : AccessibilityService() {

    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.d("SkipAdService", "Service is now connected!")

        val info = AccessibilityServiceInfo().apply {
            // Trigger on content & window changes
            eventTypes = AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED or
                    AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED

            // Feedback type can be generic; adding spoken helps reliability on some devices
            feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC or
                    AccessibilityServiceInfo.FEEDBACK_SPOKEN

            notificationTimeout = 100

            // Limit strictly to YouTube
            packageNames = arrayOf("com.google.android.youtube")
        }
        serviceInfo = info
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event == null || rootInActiveWindow == null) return

        // Only run when YouTube is active
        if (event.packageName?.toString() != "com.google.android.youtube") return

        traverseNode(rootInActiveWindow)
    }

    private fun traverseNode(node: AccessibilityNodeInfo?) {
        if (node == null) return

        val text = node.text?.toString() ?: ""
        val desc = node.contentDescription?.toString() ?: ""
        val id = node.viewIdResourceName ?: ""

        if (text.isNotEmpty()) Log.d("SkipAdService", "Node text: '$text'")
        if (desc.isNotEmpty()) Log.d("SkipAdService", "Node contentDescription: '$desc'")
        if (id.isNotEmpty()) Log.d("SkipAdService", "Node id: '$id'")

        // Try clicking if we detect Skip button in text, contentDescription or id
        if (text.contains("Skip", ignoreCase = true) ||
            desc.contains("Skip", ignoreCase = true) ||
            id.contains("skip_ad_button", ignoreCase = true)) {
            clickNodeOrParent(node, "detected")
        }

        // Recurse through children
        for (i in 0 until node.childCount) {
            traverseNode(node.getChild(i))
        }
    }

    private fun clickNodeOrParent(node: AccessibilityNodeInfo, source: String) {
        var target: AccessibilityNodeInfo? = node
        while (target != null && !target.isClickable) {
            target = target.parent
        }
        if (target != null) {
            target.performAction(AccessibilityNodeInfo.ACTION_CLICK)
            Log.d(
                "SkipAdService",
                "Clicked Skip Ad via $source: '${node.text ?: node.contentDescription}'"
            )
        }
    }

    override fun onInterrupt() {
        // Nothing to handle here
    }
}
