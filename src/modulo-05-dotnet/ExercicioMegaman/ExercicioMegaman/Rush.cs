using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class Rush : Robo, IUpgrade
    {
        protected override int Ataque
        {
            get
            {
                return 4 + CalcularBonusAtaqueEDefesa(1);
            }
        }

        protected override int Defesa
        {
            get
            {
                return 3 + CalcularBonusAtaqueEDefesa(0);
            }
        }

        public override void EquiparUpgrade(IUpgrade upgrade)
        {
            if (Upgrades.Count < 2)
                Upgrades.Add(upgrade);
        }

        public int BonusAtaque
        {
            get
            {
                return this.Ataque;
            }
        }

        public int BonusDefesa
        {
            get
            {
                return this.Defesa;
            }
        }
    }
}
