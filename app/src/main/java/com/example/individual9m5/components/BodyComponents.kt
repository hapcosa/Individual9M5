package com.example.individual9m5.components

import android.view.textclassifier.TextLinks.TextLink
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.MultiChoiceSegmentedButtonRowScope
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun space(size:Dp){
    Spacer(modifier = Modifier.height(size))
}
@Composable
fun MainTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
){

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun multibutton() {
    val checkedList = remember { mutableStateListOf<Int>() }
    val listoptions= listOf("Hombre","Mujer")
    var changeCheked= remember {false
    }
    MultiChoiceSegmentedButtonRow{
    listoptions.forEachIndexed{index,label-> 
        SegmentedButton(checked=index in checkedList, onCheckedChange = {
            if (index in checkedList) {
                checkedList.remove(index)
            } else {
                checkedList.add(index)
                checkedList.remove(index-1)
                checkedList.remove(index+1)
            }
        }, shape = SegmentedButtonDefaults.itemShape(index = index, count = listoptions.size) ) {
            Text(label)
        }
    }
}

}
@Composable
fun resultText(text:String){
    Text(text = text, color = Color.Black, fontSize = 25.sp)
}
@Composable
fun MainButton(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
    onClick:() -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = color,
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Alert(
    title: String,
    msj: String,
    confirmText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissClick,
        title = { Text(text = title) },
        text = { Text(text = msj) },
        shape = CutCornerShape(10.dp),
        confirmButton = {
            Button(onClick = onConfirmClick) {
                Text(text = confirmText)
            }
        }


    )
}
