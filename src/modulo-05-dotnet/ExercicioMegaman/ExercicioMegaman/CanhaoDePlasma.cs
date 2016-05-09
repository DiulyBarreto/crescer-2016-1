using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class CanhaoDePlasma : IUpgrade
    {
        public int ConcederBonusAtaque
        {
            get
            {
                return 2;
            }
        }

        public int ConcederBonusDefesa
        {
            get
            {
                return 0;
            }
        }
    }
}
