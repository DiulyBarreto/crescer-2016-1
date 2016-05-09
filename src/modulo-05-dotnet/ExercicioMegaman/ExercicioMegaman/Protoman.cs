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
                int bonus = 0;

                if (this.Upgrades != null)
                {
                    foreach (IUpgrade upgrade in Upgrades)
                    {
                        bonus += upgrade.ConcederBonusDefesa;
                    }
                }

                return 2 + bonus;
            }
        }

        protected override int Ataque
        {
            get
            {
                int bonus = 0;

                if(this.Upgrades != null)
                {
                    foreach(IUpgrade upgrade in Upgrades)
                    {
                        bonus += upgrade.ConcederBonusAtaque;
                    }
                }

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
            return "Nome: " + this.GetType().Name + ", Vida: " + this.Vida + ", Ataque: " + this.Ataque + ", Defesa: " + this.Defesa;
        }
        
    }

    
}
