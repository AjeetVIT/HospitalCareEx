$(document).ready(function(){
        //1.hide Error Section
        $("#specCodeError").hide();
        $("#specNameError").hide();
        $("#specNoteError").hide();

//2.Define Error Variable
        var specCodeError=false;
        var specNameError=false;
        var specNoteError=false;
        //3.Define Validate Function
        function vaidate_specCode(){
            var val=$("#specCode").val();
            var exp= /^[A-Z\s]{4,50}$/;
            if(val==''){
                $("#specCodeError").show();
                specCodeError=false;
                $("#specCodeError").html("*<b>Code</b> Can Not Be Empty");
                $("#specCodeError").css('color','green');
                } else if(!exp.test(val)){
                $("#specCodeError").show();
                specCodeError=false;
                $("#specCodeError").html("*<b>Code</b> must be 4 to 50 char only");
                $("#specCodeError").css('color','green');
                } else {
                    $("#specCodeError").hide();
                    specCodeError=true;
                    }
            return specCodeError;
                 }
        function vaidate_specName(){
            var val=$("#specName").val();
            var exp= /^[A-Za-z0-9\s\.]{4,40}$/;
            if(val==''){
                $("#specNameError").show();
                 $("#specNameError").html("*<b>Name</b> Can Not Be Empty");
                $("#specNameError").css('color','green');
                specNameError=false;
                } else if(!exp.test(val)){
                $("#specNameError").show();
                $("#specNameError").html("*<b>Name</b> must be 4 to 40 char only");
                $("#specNameError").css('color','green');
                specNameError=false;
                } else {
                    $("#specNameError").hide();
                    specNameError=true;
                    
                
                }
            return specNameError;
        }
        
        function vaidate_specNote(){
            var val=$("#specNote").val();
            var exp= /^[A-Za-z0-9\s\.\-\,]{10,250}$/;
            if(val==''){
                $("#specNoteError").show();
                 $("#specNoteError").html("*<b>Note</b> Can Not Be Empty");
                $("#specNoteError").css('color','green');
                specNoteError=false;
                } else if(!exp.test(val)){
                $("#specNoteError").show();
                $("#specNoteError").html("*<b>Note</b> must be 4 to 250 char only");
                $("#specNoteError").css('color','green');
                specNoteError=false;
                } else {
                    $("#specNoteError").hide();
                    specNoteError=true;
                    
                
                }
            return specNoteError;
        }
        
            //4.action-event
            $("#specCode").keyup(function(){
                $(this).val($(this).val().toUpperCase());
                vaidate_specCode();
            });
                $("#specName").keyup(function(){
                
                vaidate_specName();

            });
            $("#specNote").keyup(function(){
                
                vaidate_specNote();

            });
            //5.On Submitt
            $("#specForm").submit(function(){
                vaidate_specCode();
                vaidate_specName();
                vaidate_specNote();
              if(specCodeError&& specNameError && specNoteError)
              return true;
              else return false;

            });
        
    });