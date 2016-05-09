using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMegaman;

namespace TestExercicio1
{
    [TestClass]
    public class MegamanTest
    {
        [TestMethod]
        public void MegamanAtacarUmRoboUmaVez()
        {
            var bot = new Bot();
            var megaman = new Megaman();
            megaman.Atacar(bot);

            Assert.AreEqual(94, bot.Vida);
        }

        [TestMethod]
        public void MegamanRecerAtaqueUmaVez()
        {
            var bot = new Bot();
            var megaman = new Megaman();
            bot.Atacar(megaman);

            Assert.AreEqual(95, megaman.Vida);
        }

        [TestMethod]
        public void MegamanComMenosDe30DeVidaAtacarRobo()
        {
            var bot = new Bot();
            var megaman = new Megaman();

            for(int i = 0; i <= 15; i++)
            {
                bot.Atacar(megaman);
            }

            megaman.Atacar(bot);

            Assert.AreEqual(91, bot.Vida);
        }

        [TestMethod]
        public void MegamanAtacarProtoman()
        {
            var protoman = new Protoman();
            var megaman = new Megaman();

            megaman.Atacar(protoman);

            Assert.AreEqual(96, protoman.Vida);
        }

        [TestMethod]
        public void MegamanToString()
        {
            var megaman = new Megaman();

            Assert.AreEqual("Nome: Megaman, Vida: 100, Ataque: 6, Defesa: 0", megaman.ToString());
        }

        [TestMethod]
        public void MegamanAtacarBotComBonusDeAtaque()
        {
            var megamen = new Megaman();
            var bot = new Bot();
            var bonusAtaque = new CanhaoDePlasma();
            megamen.EquiparUpgrade(bonusAtaque);

            megamen.Atacar(bot);

            Assert.AreEqual(92, bot.Vida);
        }

        [TestMethod]
        public void MegamanAtacarBotComBonusDeAtaqueEMenosDe30DeVida()
        {
            var megamen = new Megaman();
            var bot = new Bot();
            var bonusAtaque = new CanhaoDePlasma();
            var bonusAtaque2 = new BotasSuperVelocidade();

            megamen.EquiparUpgrade(bonusAtaque);
            megamen.EquiparUpgrade(bonusAtaque2);

            for(int i = 0; i < 18; i++)
            {
                bot.Atacar(megamen);
            }

            megamen.Atacar(bot);

            Assert.AreEqual(88, bot.Vida);
        }

        [TestMethod]
        public void MegamanReceberAtaqueComBonusDeDefesa()
        {
            var megamen = new Megaman();
            var bot = new Bot();
            var bonusDefesa = new EscudoDeEnergia();
            var bonusDefesa2 = new BotasSuperVelocidade();

            megamen.EquiparUpgrade(bonusDefesa);
            megamen.EquiparUpgrade(bonusDefesa2);

            bot.Atacar(megamen);

            Assert.AreEqual(98, megamen.Vida);
        }
        
    }
}
