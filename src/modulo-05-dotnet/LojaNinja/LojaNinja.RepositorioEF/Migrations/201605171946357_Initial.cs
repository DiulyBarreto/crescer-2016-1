namespace LojaNinja.RepositorioEF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false),
                    })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Email = c.String(nullable: false),
                        Senha = c.String(nullable: false),
                        Nome = c.String(nullable: false),
                        Permissao_Id = c.Int(),
                        
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Permissao", t => t.Permissao_Id)
                .Index(t => t.Permissao_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Usuario", "Permissao_Id", "dbo.Permissao");
            DropIndex("dbo.Usuario", new[] { "Permissao_Id" });
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
        }
    }
}
