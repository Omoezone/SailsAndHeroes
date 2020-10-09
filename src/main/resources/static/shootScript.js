var shootFaseVar = false;
var shootPoint = "";

$(document).ready(function () {
    $("#enableShot").click(shootFase);
    $(".test").click(markShot);
});

function shootFase(){
    if(!shootFaseVar){
        shootFaseVar = true;
        var oceanColor = {backgroundColor: 'blue'};
        $("#shootPoint").css(oceanColor);
        $("#shootPoint").attr('id', null);
    }else{
        shootFaseVar = false;
    }
    alert(shootFaseVar);
}

function markShot(){
    var css_markShot = {backgroundColor: 'red'};
    if(shootFaseVar === true) {
        $(this).css(css_markShot);
        $(this).attr('id', 'shootPoint');
        shootFaseVar = false;
    }
}