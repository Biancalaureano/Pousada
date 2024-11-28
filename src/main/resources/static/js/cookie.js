
$(document).ready(function() {
    
     $(".mudaTema").change(function() {
      
        if ($(this).is(':checked')) {
            
            let temaClaro = "claro";
            
            enviaTema(temaClaro);
      
        } else {
            
            let temaEscuro = "escuro";
            
            enviaTema(temaEscuro);
            
        }
    });
    
    function enviaTema(tema) {
        
        console.log(tema);
        
        let preferencia = {
            tema: tema
        };
        
         $.ajax({
             
                type: 'POST',
                url: 'http://localhost:8080/preferencias',
                data: preferencia
                
                })
                .done(function(response) {

                    console.log(response);
            
                    location.reload(true);

                })
                .fail(function(error) {
                    // Lidar com erros de requisição, se houver
                    console.log(error);
                });
        
    }
    
    atualizarCheckbox();
    
});




function atualizarCheckbox() {
    // Obter o valor do tema do link CSS
    var temaAtual = $(".mudaTema").val();

    // Verificar se o tema é "claro" ou "escuro"
    if (temaAtual.includes("claro")) {
        // Se for "claro", ativar o checkbox
        $(".mudaTema").prop("checked", true);
        
        $('.textoTema').text(temaAtual);
        
    } else {
        // Se for "escuro", desativar o checkbox
        $(".mudaTema").prop("checked", false);
        
        $('.textoTema').text(temaAtual);
    }
}
   
