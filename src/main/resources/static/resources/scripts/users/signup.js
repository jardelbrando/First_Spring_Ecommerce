$(document).ready(() => {

    $("#cep").focusout(function (event){
        const { value } = event.target;
        if(value){
            $.ajax({
                url: `https://viacep.com.br/ws/${value}/json/`,
                success: function (data){
                    $("#state").val(data.uf);
                    $("#city").val(data.localidade);
                    $("#street").val(data.logradouro);
                    $("#district").val(data.bairro);
                }
            });
        }
    });


    $("#submitButton").click(() => {
        $("#submit-form").submit();
    });
});



