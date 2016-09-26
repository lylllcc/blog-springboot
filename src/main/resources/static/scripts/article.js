/**
 * Created by jaxlying on 2016/9/25.
 */

$(document).ready(function () {
    $('#comment').click(function () {
        $.post('/comment',{
            "articleid": $('#articleid').val(),
            "nickname": $('#nickname').val(),
            "email": $('#email').val(),
            "body": $('#body').val()
        });
        location.reload()
    });
});