
$(document).ready(function() {
    
  $("#excluir").click(function() {
      
    // Exibe um diálogo de confirmação
    var confirmacao = confirm("Tem certeza de que deseja excluir este item?");
    
    // Verifica a resposta do usuário
    if (confirmacao) {
        
      alert("Item excluído com sucesso!");
      
    } else {
        
      alert("Exclusão cancelada.");
      
    }
    
  });
});