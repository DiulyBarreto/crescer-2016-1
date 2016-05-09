using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMegaman;

namespace TestExercicio1
{
    [TestClass]
    public class RushTest
    {
        [TestMethod]
        public void RushAtacarBotCom4DeAtaque()
        {
            var rush = new Rush();
            var bot = new Bot();

            rush.Atacar(bot);

            Assert.AreEqual(96, bot.Vida);
        }

        [TestMethod]
        public void RushReceberAtaqueCom3DeDefesa()
        {
            var rush = new Rush();
            var bot = new Bot();

            bot.Atacar(rush);

            Assert.AreEqual(98, rush.Vida);
        }

        [TestMethod]
        public void RushAtacarComBonusDeAtaque()
        {
            var rush = new Rush();
            var bot = new Bot();
            var bonus1 = new CanhaoDePlasma();
            var bonus2 = new BotasSuperVelocidade();

            rush.EquiparUpgrade(bonus1);
            rush.EquiparUpgrade(bonus2);

            rush.Atacar(bot);

            Assert.AreEqual(93, bot.Vida);
        }

        [TestMethod]
        public void RushReceberAtaqueComBonusDeDefesa()
        {
            var rush = new Rush();
            var bot = new Bot();
            var bonus1 = new EscudoDeEnergia();
            var bonus2 = new BotasSuperVelocidade();

            rush.EquiparUpgrade(bonus1);
            rush.EquiparUpgrade(bonus2);

            bot.Atacar(rush);

            Assert.AreEqual(100, rush.Vida);
        }

        [TestMethod]
        public void ProtomanAtacarComRushLendario()
        {
            var rush = new Rush();
            var protoman = new Protoman();
            var bot = new Bot();
            protoman.EquiparUpgrade(rush);

            protoman.Atacar(bot);

            Assert.AreEqual(91, bot.Vida);
        }

        [TestMethod]
        public void ProtomanAtacarComRushLendarioQuePossuiUpgrade()
        {
            var rush = new Rush();
            var protoman = new Protoman();
            var bot = new Bot();
            var bonus1 = new CanhaoDePlasma();
            rush.EquiparUpgrade(bonus1);
            protoman.EquiparUpgrade(rush);

            protoman.Atacar(bot);

            Assert.AreEqual(89, bot.Vida);
        }

        [TestMethod]
        public void ProtomanReceberAtaqueComRushLendario()
        {
            var rush = new Rush();
            var protoman = new Protoman();
            var bot = new Bot();
            protoman.EquiparUpgrade(rush);

            bot.Atacar(protoman);

            Assert.AreEqual(100, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanReceberAtaqueComRushLendarioEBonusDefesaDeMegaman()
        {
            var rush = new Rush();
            var protoman = new Protoman();
            var megaman = new Megaman();
            var bonusAtaque = new CanhaoDePlasma();
            var bonusDefesa = new EscudoDeEnergia();

            megaman.EquiparUpgrade(bonusAtaque);
            protoman.EquiparUpgrade(bonusDefesa);

            protoman.EquiparUpgrade(rush);

            megaman.Atacar(protoman);

            Assert.AreEqual(99, protoman.Vida);

        }
    }
}
