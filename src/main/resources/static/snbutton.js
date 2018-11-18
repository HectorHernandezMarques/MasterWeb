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
        jQuery('.new-order-input').on('input propertychange', function () {
            var isFormReady = true;
            jQuery('.new-order-input').each(function(){
                if (jQuery(this).val() == '') {
                    isFormReady = false;
                }
                console.log(isFormReady);
            });
            if (isFormReady) {
                jQuery(button).attr("disabled", false);
                jQuery(button).text(disabletext);
            } else {
                jQuery(button).attr("disabled", true);
                jQuery(button).text(enabletext);
            }
        });
    }
}
