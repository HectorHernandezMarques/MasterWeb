function strikeTextBox(checkbox) {
    var xd = checkbox.parentNode.getElementsByClassName("order-form-input");
    console.log(xd);
    for (var i = 0; i < xd.length; ++i) {
        console.log(xd.item(i).textContent);
        if (checkbox.checked) {
            xd.item(i).style = "text-decoration: line-through;";
        }
        else {
            xd.item(i).style = "";
        }
    }
}