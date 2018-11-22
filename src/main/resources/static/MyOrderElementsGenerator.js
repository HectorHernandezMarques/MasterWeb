function createNewElementInForm() {
    var paragraph = document.createElement("p");
    paragraph.className = "element-paragraph";

    var newElement = document.createElement("input");
    newElement.type = "text";
    newElement.name = "orderElementNames";
    newElement.placeholder = "New Element";
    newElement.className = "order-form-input";

    paragraph.appendChild(newElement);

    document.getElementById("order-form-elements").appendChild(paragraph);

    generateDeleteButtons("order-form-elements");

    disableButtonIfSomeInputIsEmpty("#snbtn", ".order-form-input");
}

function createNewElementInFormWithCheckbox() {
    var paragraph = document.createElement("p");
    paragraph.className = "element-paragraph";

    var strikedCheckBox = document.createElement("input");

    strikedCheckBox.type = "checkbox";
    strikedCheckBox.onchange = function (ev) {
        strikeTextBox(this);
    };
    strikedCheckBox.name = "strikedElements";
    strikedCheckBox.value = document.getElementById("order-form-elements").childElementCount + 1;
    strikedCheckBox.className = "order-form-checkbox check-box";

    var newElement = document.createElement("input");
    newElement.type = "text";
    newElement.name = "orderElementNames";
    newElement.placeholder = "New Element";
    newElement.className = "order-form-input";

    paragraph.appendChild(strikedCheckBox);
    paragraph.appendChild(newElement);

    document.getElementById("order-form-elements").appendChild(paragraph);

    generateDeleteButtons("order-form-elements");

    disableButtonIfSomeInputIsEmpty("#snbtn", ".order-form-input");
}

function generateDeleteButtons(divWithElements) {
    $('.delete-element-button').remove();
    if (document.getElementById(divWithElements).childElementCount > 1) {
        elementParagraphs = document.getElementsByClassName("element-paragraph");
        for (var j = 0; j < elementParagraphs.length; j++) {
            var deleteButton = document.createElement("button");
            deleteButton.id = _.uniqueId("delete-element-button-id-");
            deleteButton.type = "button";
            deleteButton.className = "delete-element-button btn btn-secondary";
            deleteButton.appendChild(document.createTextNode("Delete"));
            elementParagraphs.item(j).appendChild(deleteButton);
            $("#" + deleteButton.id).on("click", function () {
                this.parentNode.remove();
                generateDeleteButtons("order-form-elements");
                disableButtonIfSomeInputIsEmpty("#snbtn", ".order-form-input");
            });

        }
    }
}
