﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class EscudoDeEnergia : IUpgrade
    {
        public int ConcederBonusAtaque
        {
            get
            {
                return 0;
            }
        }

        public int ConcederBonusDefesa
        {
            get
            {
                return 2;
            }
        }
    }
}
