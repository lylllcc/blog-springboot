/**
 * Created by jaxlying on 2016/9/25.
 */


$(document).ready(function () {

    $('#comment').click(function () {
        var articleid = $('#articleid').val();

        $.post('/articles/' + articleid,{
            "nickname": $('#nickname').val(),
            "email": $('#email').val(),
            "body": $('#body').val()
        });
    });
    
});