
$(document).ready(function () {
    
});


function enviarSolicitacao() {
        
        // Impede o envio normal do formulário
        event.preventDefault();

        
        //Serializa os valores de controle de formulário enviados
        //para serem enviados ao servidor da Web com a solicitação 
        let formValues = $("#form").serialize();

        $.ajax({

             type: 'POST',
             url: 'http://localhost:8080/pagina-inicial',
             data: formValues

        })
        .done(function (data) {
            // enviar mensagem de registro salvo
            alert("Solicitação enviada!");

        })
        .fail(function (msg) {

            // caso a solicitação de POST tenha falhado
            alert("Falha no envio");

        });
    };
    
    
    
    
 
    


