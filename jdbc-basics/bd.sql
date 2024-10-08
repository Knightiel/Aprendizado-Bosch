-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema delivery
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema delivery
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `delivery` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `delivery` ;

-- -----------------------------------------------------
-- Table `delivery`.`tbestado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery`.`tbestado` (
  `sigla` VARCHAR(2) NOT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`sigla`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `delivery`.`tbcliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `delivery`.`tbcliente` (
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `endereco1` VARCHAR(150) NOT NULL,
  `endereco2` VARCHAR(150) NULL DEFAULT NULL,
  `bairro` VARCHAR(50) NOT NULL,
  `cidade` VARCHAR(50) NOT NULL,
  `estado` VARCHAR(2) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `idade` INT NOT NULL,
  `primeira_compra` TINYINT(1) NULL DEFAULT '0',
  `data_nascimento` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`cpf`),
  INDEX `estado` (`estado` ASC) VISIBLE,
  CONSTRAINT `tbcliente_ibfk_1`
    FOREIGN KEY (`estado`)
    REFERENCES `delivery`.`tbestado` (`sigla`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
