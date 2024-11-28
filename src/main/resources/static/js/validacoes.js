

$(document).ready(function() {

    $("form").validate({
        rules: {
            txtNome: {
                required: true
            },        
            txtDataEntrada: {
                required: true,
                date: true
                
            },
            txtObservacoes: {
                
                
            },
            txtEmail: {
                required: true,
                email: true
                
            },
            txtDataSaida: {
                required: true,
                date: true
                
            },
            txtCriancas: {
                required: true
                
            },
            txtAdultos: {
                required: true
                
            }
        },
        messages: {
            txtNome: {
                required: "campo nome é obrigatório"

            },        
            txtDataEntrada: {
                required: "campo Data Entrada é obrigatório"
                
            },
            txtObservacoes: {
                
                
            },
            txtEmail: {
                required: "campo e-mail é obrigatório",
                email: "O e-mail deve estar no formato: xxx@xxxx.xxx"
                
            },
            txtDataSaida: {
                required: "campo Data Saída é obrigatório"
                
            },
            txtCriancas: {
                required: "campo crianças é obrigatório"
                
            },
            txtAdultos: {
                required: "campo adultos é obrigatório"
                
            }      
        }
    });
});

 $(document).ready(function () {

     $('#txtCriancas').mask('0');
     $('#txtAdultos').mask('0');

 });

