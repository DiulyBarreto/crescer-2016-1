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
                int bonus = 0;

                if (this.Upgrades != null)
                {
                    foreach (IUpgrade upgrade in Upgrades)
                    {
                        bonus += upgrade.BonusAtaque;
                    }
                }

                return 4 + bonus;
            }
        }

        protected override int Defesa
        {
            get
            {
                int bonus = 0;

                if (this.Upgrades != null)
                {
                    foreach (IUpgrade upgrade in Upgrades)
                    {
                        bonus += upgrade.BonusDefesa;
                    }
                }

                return 3 + bonus;
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
