// JavaScript Document
var number_count = 1;
$(function(){

    //phone number counter   
    
       
    $("#add_num").click(function(){
        
        add_phone_number();
    });

    $(".item").hide();
    $(".item2").hide();
    
    $(".selected").show();



    $(".form_section").click(function(){
           
        $(".item").removeClass("selected");
        $(this).addClass("selected");
        show_form($(this).attr("name"));
    });


});

function show_form(type){
    if($("." + type).hasClass("selected")==false){
        $(".item").fadeOut();
        $("." + type).fadeIn();
        $(".selected").removeClass("selected");
        $("." + type).addClass("selected");
		
    }
}


//MAIDEN INOUT FIELD
function showMaiden(){
    if((document.getElementById("sex").value == "male")){
        document.getElementById("m_d").type = "hidden";
        document.getElementById("maiden_field").style.display =  "none";
             
    }
    else if((document.getElementById("sex").value == "female") && (document.getElementById("marital_status").value == "married")){
                    
        document.getElementById("m_d").type = "text";
        document.getElementById("maiden_field").style.display =  "block";
    }
    else if(document.getElementById("marital_status").value != "married"){
        document.getElementById("m_d").type = "hidden";
        document.getElementById("maiden_field").style.display =  "none";
    }
               
}
            
            
//ADDING MORE PHONE NUMBERS
function add_phone_number(){
    if(number_count < 3){
        document.getElementById('numbers').innerHTML += "OTHER NUMBER&nbsp;"; 
        document.getElementById('numbers').innerHTML += number_count;
        document.getElementById('numbers').innerHTML += "<span>&nbsp;<input type='text' name='phone_number' /></span>";
        number_count++;
    }
    else{
         document.getElementById('add_num').style.display = "none";
        document.getElementById('numbers').innerHTML += "<code>Maximium phone numbers reached</code>";                        
    }
}

