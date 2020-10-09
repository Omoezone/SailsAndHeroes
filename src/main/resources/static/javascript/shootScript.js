//Benjamin Gustavsen
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
        //Vi kan for some reason kun sende et array, så vi lægger koordinatet
        //for skud ind i det array. Ikke optimalt
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
        coords.push(+$(this).find("#coordinateX").val());
        coords.push(+$(this).find("#coordinateY").val());
        //coords.push(1); //1 for shoot 0 for not TODO WHAT IF WE SHOOT AT 0.1????
        shootFaseVar = false;
    }
}