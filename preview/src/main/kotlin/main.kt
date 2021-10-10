import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.window.singleWindowApplication

fun main() = singleWindowApplication {
    MainContent()
}

@Composable
fun MainContent() {
    var text by remember { mutableStateOf("Hello!!") }

    MaterialTheme {
        Button(onClick = { text = "Hello, Desktop!" }) {
            Text(text)
        }
    }
}

@Preview
@Composable
fun MainContent_Preview() {
    MainContent()
}