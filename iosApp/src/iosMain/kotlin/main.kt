import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import com.vint.app.App

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
