using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public interface IUpgrade
    {
        int ConcederBonusAtaque { get; }
        int ConcederBonusDefesa { get; }
    }
}
