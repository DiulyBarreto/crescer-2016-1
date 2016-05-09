using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class BotasSuperVelocidade : IUpgrade
    {
        public int ConcederBonusAtaque
        {
            get
            {
                return 1;
            }
        }

        public int ConcederBonusDefesa
        {
            get
            {
                return 1;
            }
        }
    }
}
