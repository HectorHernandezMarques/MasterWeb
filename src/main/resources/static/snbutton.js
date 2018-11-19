var SNButton = {
    init: function (e, params) {
        var button = "#" + e;
        var input = "#" + jQuery(button).data("snnode");

        if (params) {
            var enabletext = params.enabletext ? params.enabletext : $(button).text();
            var disabletext = params.disabletext ? params.disabletext : $(button).text();
        }
        jQuery(button).attr("disabled", true);
        jQuery(button).text(disabletext);

        jQuery('.order-form-input-div').on('input propertychange', function () {
            disableButtonIfSomeInputIsEmpty(button, ".order-form-input")
        });
        jQuery('#new-element-button').on('click', function () {
            disableButtonIfSomeInputIsEmpty(button, ".order-form-input")
        });
    }
};

var disableButtonIfSomeInputIsEmpty = function (button, inputClass) {
    var isFormReady = true;
    jQuery(inputClass).each(function () {
        if (jQuery(this).val() == '') {
            isFormReady = false;
        }
    });
    console.log(isFormReady);
    if (isFormReady) {
        jQuery(button).attr("disabled", false);
    } else {
        jQuery(button).attr("disabled", true);
    }
};