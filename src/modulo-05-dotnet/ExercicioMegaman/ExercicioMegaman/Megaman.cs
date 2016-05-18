using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class Megaman : Robo
    {

        protected override int Ataque
        {
            get
            {
                return 6 + CalcularBonusAtaqueEDefesa(1);
            }
        }

        protected override int Defesa
        {
            get
            {
                 return base.Defesa + CalcularBonusAtaqueEDefesa(0);
            }
        }

        public override void Atacar(Robo robo)
        {
            if (this.Vida < 30)
            {
                robo.ReceberAtaque(this.Ataque + 3);
            }
            else
            {
                base.Atacar(robo);
            }

        }

        public override string ToString()
        {
            return string.Format("Nome: {0}, Vida: {1}, Ataque: {2}, Defesa: {3}", this.GetType().Name, this.Vida, this.Ataque, this.Defesa);
        }


    }
}
