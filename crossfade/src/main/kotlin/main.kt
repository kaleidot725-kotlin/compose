import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun main() = Window {
    var selectedPageName by remember { mutableStateOf("ONE") }
    MaterialTheme {
        Crossfade(
            current = selectedPageName,
            modifier = Modifier.fillMaxSize(),
            animation = tween(1000)
        ) { pageName ->
            when (pageName) {
                "ONE" -> {
                    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
                        Text("1ページ目", style = TextStyle(fontSize = 32.sp, color = Color.White))
                        Button(
                            onClick = { selectedPageName = "TWO" },
                            modifier = Modifier.width(200.dp).height(100.dp).align(Alignment.Center)
                        ) {
                            Text("2ページ目に遷移する")
                        }
                    }
                }
                "TWO" -> {
                    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
                        Text("2ページ目", style = TextStyle(fontSize = 32.sp, color = Color.Black))
                        Button(
                            onClick = { selectedPageName = "ONE" },
                            modifier = Modifier.width(200.dp).height(100.dp).align(Alignment.Center)
                        ) {
                            Text("1ページ目に遷移する")
                        }
                    }
                }
            }
        }
    }
}
