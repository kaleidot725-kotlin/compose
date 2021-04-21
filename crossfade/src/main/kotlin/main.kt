import androidx.compose.desktop.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val ONE_PAGE_NAME = "ONE"
const val TWO_PAGE_NAME = "TWO"

fun main() {
    Window("CROSSFADE") {
        var selectedPageName by remember { mutableStateOf("ONE") }

        fun navigateOnePage() {
            selectedPageName = ONE_PAGE_NAME
        }

        fun navigateTwoPage() {
            selectedPageName = TWO_PAGE_NAME
        }

        MaterialTheme {
            when (selectedPageName) {
                ONE_PAGE_NAME -> OnePage(onNavigate = { navigateTwoPage() })
                TWO_PAGE_NAME -> TwoPage(onNavigate = { navigateOnePage() })
            }
        }
    }
}

@Composable
fun OnePage(onNavigate: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Black)) {
        Text("1ページ目", style = TextStyle(fontSize = 32.sp, color = Color.White))
        Button(
            onClick = onNavigate,
            modifier = Modifier.width(200.dp).height(100.dp).align(Alignment.Center)
        ) {
            Text("2ページ目に遷移する")
        }
    }
}

@Composable
fun TwoPage(onNavigate: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Text("2ページ目", style = TextStyle(fontSize = 32.sp, color = Color.Black))
        Button(
            onClick = onNavigate,
            modifier = Modifier.width(200.dp).height(100.dp).align(Alignment.Center)
        ) {
            Text("1ページ目に遷移する")
        }
    }
}