package com.example.designandthemingweek3acc

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Surface
import com.example.designandthemingweek3acc.ui.theme.DesignAndThemingWeek3AccTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //DesignAndThemingWeek3AccTheme { // Adding Theming From themes.xml
                //Surface(modifier=Modifier.fillMaxSize(),shape= MaterialTheme.shapes.large, shadowElevation=1.dp) { // Adding Surface
                    //FeetToMetres(mod = Modifier
                        //.border(4.dp, Color.Red)
                        //.padding(32.dp)
                        //.fillMaxSize())

            ShoppingList()
                }
            }
        }


    @Composable
    fun TwoTextsSpacer() {
        Column {
            Text(
                "Hello World!",
                color = Color.Red,
                fontStyle = FontStyle.Italic,
                fontSize = 24.sp,
                fontFamily = FontFamily.Serif
            )
            Spacer(Modifier.height(32.dp)) // Adds a space of 32 density independent pixels
            Text("Welcome to Android Development", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }
    }


    //Call composable by adding modifier in the call with parameter 'mod' = 'TwoTextsPadding(mod = Modifier.border(2.dp, Color.Blue).padding(16.dp))'
    @Composable
    fun TwoTextsPadding(mod: Modifier) { // Add modifier in parameters
        Column(mod) {// Choose where to input modifier, here it is in the Column
            Text("Hello World!", color = Color.Red, fontStyle=FontStyle.Italic, fontSize=24.sp, fontFamily=FontFamily.Serif)
            Spacer(Modifier.height(32.dp))
            Text("Welcome to Android Development", fontWeight=FontWeight.Bold, fontSize=18.sp)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FeetToMetres(mod: Modifier){
        var feet by remember{ mutableStateOf(0.0) }
        var FeetInt = feet.toInt()
        var MetresInt = FeetInt*0.305
        var Metres = MetresInt.toString()
        Column(mod) {
            Row {
                TextField(value = "$feet", onValueChange = { feet = it.toDouble() }, Modifier.weight(2.0f)) // Making a 2:1 ratio on the row
                Button(
                    onClick = {feet=0.0},
                    Modifier
                        .padding(8.dp)
                        .weight(1.0f)
                ){"Clear"}
            }
            Text("Metres $Metres")
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ShoppingList() {
        var list by remember { mutableStateOf(listOf<String>()) } //Create List
        var currentItem by remember { mutableStateOf("") }
        Column {
            TextField(value = currentItem, onValueChange = { currentItem = it })
            Button(onClick = {
                var tempList = list.toMutableList() // Create Temporary List
                tempList.add(currentItem) // Add Item to temporary List
                list = tempList // Make original list temporary list to update
            }) { Text("Add Item") }

            list.forEach {
                Text(it) // Print each item
                    }
        }

    }