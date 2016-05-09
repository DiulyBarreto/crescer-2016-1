using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMegaman;

namespace TestExercicio1
{
    [TestClass]
    public class ProtomanTest
    {
        [TestMethod]
        public void ProtomanReceberTresAtaques()
        {
            var protoman = new Protoman();
            var bot = new Bot();

            for(int i = 0; i < 3; i++)
            {
                bot.Atacar(protoman);
            }

            Assert.AreEqual(91, protoman.Vida);      
        }

        [TestMethod]
        public void ProtomanAtacarCincoVezes()
        {
            var protoman = new Protoman();
            var bot = new Bot();

            for (int i = 0; i < 5; i++)
            {
                protoman.Atacar(bot);
            }

            Assert.AreEqual(75, bot.Vida);
        }

        [TestMethod]
        public void ProtomanMorrerUmaVezERessuscitar()
        {
            var protoman = new Protoman();
            var bot = new Bot();

            for (int i = 0; i < 34; i++)
            {
                bot.Atacar(protoman);
            }
            

            Assert.AreEqual(20, protoman.Vida);

        }

        [TestMethod]
        public void ProtomanMorrerUmaVezEAtacarCom7DeAtaque()
        {
            var protoman = new Protoman();
            var bot = new Bot();

            for (int i = 0; i < 34; i++)
            {
                bot.Atacar(protoman);
            }

            protoman.Atacar(bot);

            Assert.AreEqual(93, bot.Vida);
        }

        [TestMethod]
        public void ProtomanMorrerDuasVezesEVidaNãoVoltarA20()
        {
            var protoman = new Protoman();
            var bot = new Bot();

            for (int i = 0; i < 34; i++)
            {
                bot.Atacar(protoman); // vida volta a 20
            }

            for(int i = 0; i < 7; i++)
            {
                bot.Atacar(protoman);
            }

            Assert.AreEqual(-1, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanAtacarMegaman()
        {
            var protoman = new Protoman();
            var megaman = new Megaman();

            protoman.Atacar(megaman);

            Assert.AreEqual(95, megaman.Vida);
        }

        [TestMethod]
        public void ProtomanToString()
        {
            var protoman = new Protoman();

            Assert.AreEqual("Nome: Protoman, Vida: 100, Ataque: 5, Defesa: 2", protoman.ToString());
        }

        [TestMethod]
        public void ProtomanAtacarBotComBonusDeAtaque()
        {
            var bonusAtaque = new CanhaoDePlasma();
            var protoman = new Protoman();
            var bot = new Bot();
            protoman.EquiparUpgrade(bonusAtaque);

            for(int i = 0; i < 3; i++)
            {
                protoman.Atacar(bot);
            }

            Assert.AreEqual(79, bot.Vida);
        }

        [TestMethod]
        public void ProtomanAtacarMegamanComBonusDeAtaque()
        {
            var bonusAtaque = new CanhaoDePlasma();
            var protoman = new Protoman();
            var megaman = new Megaman();
            protoman.EquiparUpgrade(bonusAtaque);

            for (int i = 0; i < 5; i++)
            {
                protoman.Atacar(megaman);
            }

            Assert.AreEqual(65, megaman.Vida);
        }

        [TestMethod]
        public void ProtomanMorrerUmaVezEAtacarComBonusDeAtaque()
        {
            var protoman = new Protoman();
            var bot = new Bot();

            for (int i = 0; i < 34; i++)
            {
                bot.Atacar(protoman); // vida volta a 20
            }

            var bonusAtaque = new CanhaoDePlasma();
            var bonusAtaque2 = new BotasSuperVelocidade();

            protoman.EquiparUpgrade(bonusAtaque);
            protoman.EquiparUpgrade(bonusAtaque2);

            protoman.Atacar(bot);

            Assert.AreEqual(90, bot.Vida);
        }

        [TestMethod]
        public void ProtomanReceberAtaqueComBonusDeDefesaENaoReceberDano()
        {
            var protoman = new Protoman();
            var bot = new Bot();

            var bonusAtaque = new CanhaoDePlasma();
            var bonusDefesa = new EscudoDeEnergia();
            var bonusDefesa2 = new BotasSuperVelocidade();

            protoman.EquiparUpgrade(bonusAtaque);
            protoman.EquiparUpgrade(bonusDefesa);
            protoman.EquiparUpgrade(bonusDefesa2);

            for (int i = 0; i < 34; i++)
            {
                bot.Atacar(protoman);
            }

            Assert.AreEqual(100, protoman.Vida);
        }



    }
}
