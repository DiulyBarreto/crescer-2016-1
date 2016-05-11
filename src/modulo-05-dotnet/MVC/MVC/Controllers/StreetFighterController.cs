using MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class StreetFighterController : Controller
    {        
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            return View();
        }

        public ActionResult SobreMim()
        {
            var pessoa = new SobreMimModel()
            {
                Nome = "Diuly Barreto",
                Idade = 20,
                Curso = "Analise e Desenvolvimento de Sistemas",
                Facebook = "https://www.facebook.com/diuly.barreto",
                SrcImagem = "../Content/Imagens/sobre_mim.jpg"
            };

            return View(pessoa);
        }
    }
}