package top.kengtion.apidemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import top.kengtion.apidemo.ui.theme.DSApiTheme
import top.kengtion.dsapi.AuthApi
import top.kengtion.dsapi.DSConfig
import top.kengtion.dsapi.NetHelper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DSApiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Button(onClick = { testAuth() }) {
                        Text(text = "Auth")
                    }
                }
            }
        }
    }

    private fun testAuth(){
        DSConfig.domain = "192.168.2.100"
        runBlocking {
            launch(Dispatchers.IO) {
                    val data = AuthApi.query()
                    Log.d("TEST", "data = $data")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DSApiTheme {
        Greeting("Android")
    }
}