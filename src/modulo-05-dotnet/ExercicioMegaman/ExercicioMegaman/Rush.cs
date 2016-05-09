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
                        bonus += upgrade.ConcederBonusAtaque;
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
                        bonus += upgrade.ConcederBonusDefesa;
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

        public int ConcederBonusAtaque
        {
            get
            {
                return this.Ataque;
            }
        }

        public int ConcederBonusDefesa
        {
            get
            {
                return this.Defesa;
            }
        }
    }
}
