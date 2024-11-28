
$(document).ready(function() {
    
  $(".excluir").click(function(event) {
      
     // Evitar o comportamento padrão do link
        event.preventDefault();
        
        let url = $(event.target).attr('href');

        // Exibir um diálogo de confirmação
        let confirmacao = confirm("Tem certeza de que deseja excluir este item?");

        // Verificar a resposta do usuário
        if (!confirmacao) {
            
            alert("Exclusão cancelada.");
        }
        else if (confirmacao) {
            
            // Enviar a solicitação AJAX
            $.ajax({
                type: "DELETE",
                url: url
            })
            .done(function(response) {
                
                // Remover a linha da tabela após a exclusão bem-sucedida
                $(event.target).closest("tr").remove();
                
                alert("Item excluído com sucesso!");
            })
            .fail(function() {
                
                alert("Erro ao excluir o objeto.");
            });
        } 
    
  });
});