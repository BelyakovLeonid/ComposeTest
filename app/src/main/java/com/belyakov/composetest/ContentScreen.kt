package com.belyakov.composetest

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ContentScreen(
    names: List<String>
) {
    LazyColumn(modifier = Modifier.padding(12.dp)) {
        items(1000) { name ->
            ListItem(
                title = "name $name",
                subtitle = "name $name",
                modifier = Modifier,
            )
        }
    }
}

@Composable
fun ListItem(
    title: String,
    subtitle: String,
    modifier: Modifier
) {
    var isExpanded by rememberSaveable {
        mutableStateOf(false)
    }

    Card(
        backgroundColor = MaterialTheme.colors.primary,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .padding(vertical = 4.dp)
            .animateContentSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title)
                Text(
                    text = "wegwerewbwrebawvwe we wrg re rg reg wergsdfeb yuymuy wegwerewbwrebawvwe we wrg re rg reg wergsdfeb yuymuy wegwerewbwrebawvwe we wrg re rg reg wergsdfeb yuymuy ",
                    style = MaterialTheme.typography.h3.copy(color = MaterialTheme.colors.error),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
            IconButton(onClick = { isExpanded = !isExpanded }) {
                Icon(
                    imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = "aaa"
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PreviewContentScreen() {
    ContentScreen(
        names = listOf(
            "o",
            "b",
            "c"
        )
    )
}