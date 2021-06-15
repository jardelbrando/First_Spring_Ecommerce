
$(()=> {
    var ids = [];
    $('body').on(
        'click',
        '.categories',
        ({currentTarget}) => {
                const {id} = currentTarget;
                if (currentTarget.classList.contains('selected')) {
                    currentTarget.classList.remove('selected');
                    ids.pop();
                } else {
                    currentTarget.classList.add('selected');
                    ids.push(id);
                }
                $('#categories').val(ids);
        }
    );

})

$("#submitButton").click(() => {

    $("#submit-form").submit();
});