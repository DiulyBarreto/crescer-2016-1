using System.ComponentModel;
using System.ComponentModel.DataAnnotations;

namespace LojaNinja.MVC.Models
{
    public class LoginViewModel
    {
        [Required]
        [DisplayName("E-mail")]
        [StringLength(100)]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        [DisplayName("Senha")]
        [StringLength(100)]
        public string Senha { get; set; }
    }
}