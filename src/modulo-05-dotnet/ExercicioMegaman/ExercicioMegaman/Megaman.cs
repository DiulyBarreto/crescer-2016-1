﻿using System;
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
                int bonus = 0;

                if (this.Upgrades != null)
                {
                    foreach (IUpgrade upgrade in Upgrades)
                    {
                        bonus += upgrade.ConcederBonusAtaque;
                    }
                }

                return 6 + bonus;
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

                return base.Defesa + bonus;
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
            return "Nome: " + this.GetType().Name + ", Vida: " + this.Vida + ", Ataque: " + this.Ataque + ", Defesa: " + this.Defesa;
        }


    }
}
