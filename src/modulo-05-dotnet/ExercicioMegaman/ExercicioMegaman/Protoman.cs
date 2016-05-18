using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class Protoman : Robo
    {

        private bool JaMorreuUmaVez { get; set; }

        protected override int Defesa
        {
            get
            {
                return 2 + CalcularBonusAtaqueEDefesa(0);
            }
        }

        protected override int Ataque
        {
            get
            {
                int bonus = CalcularBonusAtaqueEDefesa(1);

                if (JaMorreuUmaVez)
                    return 7 + bonus;

                return base.Ataque + bonus;


           }
            
        }

        

        public override void ReceberAtaque(int ataque)
        {
            base.ReceberAtaque(ataque);
            if(this.Vida <= 0 && !JaMorreuUmaVez)
            {
                JaMorreuUmaVez = true;
                this.Vida = 20;
            }
        }

        public override string ToString()
        {
            return string.Format("Nome: {0}, Vida: {1}, Ataque: {2}, Defesa: {3}", this.GetType().Name, this.Vida, this.Ataque, this.Defesa);
        }
        
    }

    
}
