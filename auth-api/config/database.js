import { Sequelize } from "sequelize";
const sequelize = new Sequelize("auth", "auth", "auth", {
    host: "localhost",
    dialect: "postgres",
    quoteIdentifiers: false,
    define: {
        syncOnAssociation: true,
        timestamps: false,
        underscored: true,
        underscoredAll: true,
        freezeTableName: true,
    },
});

sequelize.authenticate().then(() => {
    console.log("Conexão realizada com sucesso!");
}).catch((err) => {
    console.error("Erro ao conectar com o banco de dados: ", err.message);
});

export default sequelize;