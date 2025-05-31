CREATE DATABASE projekat1;
USE projekat1;

-- Tabela Doktor
CREATE TABLE Doktor (
    idDoktor INT NOT NULL CHECK (idDoktor > 0),
    Ime VARCHAR(255) NOT NULL,
    Prezime VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL CHECK (Email LIKE '%@%'),
    PRIMARY KEY (idDoktor)
);

-- Tabela Lek
CREATE TABLE Lek (
    idLek INT NOT NULL CHECK (idLek > 0),
    Naziv VARCHAR(255) NOT NULL,
    Proizvodjac VARCHAR(255) NOT NULL,
    aktivniSastojak VARCHAR(255) NOT NULL,
    farmaceutskaGrupa VARCHAR(255) NOT NULL,
    PRIMARY KEY (idLek)
);

-- Tabela Specijalizacija
CREATE TABLE Specijalizacija (
    idSpecijalizacija INT NOT NULL CHECK (idSpecijalizacija > 0),
    Naziv VARCHAR(255) NOT NULL,
    PRIMARY KEY (idSpecijalizacija)
);

-- Tabela Dete
CREATE TABLE Dete (
    idDete INT NOT NULL CHECK (idDete > 0),
    Ime VARCHAR(255) NOT NULL,
    Prezime VARCHAR(255) NOT NULL,
    datumRodjenja DATE NOT NULL,
    PRIMARY KEY (idDete)
);

-- Tabela SkolskoDete
CREATE TABLE SkolskoDete (
    idDete INT NOT NULL CHECK (idDete > 0),
    Odeljenje VARCHAR(255) NOT NULL,
    Razred VARCHAR(255) NOT NULL,
    PRIMARY KEY (idDete),
    FOREIGN KEY (idDete) REFERENCES Dete(idDete) ON INSERT RESTRICT ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Tabela PredskolskoDete
CREATE TABLE PredskolskoDete (
    idDete INT NOT NULL CHECK (idDete > 0),
    Grupa VARCHAR(255) NOT NULL,
    PRIMARY KEY (idDete),
    FOREIGN KEY (idDete) REFERENCES Dete(idDete) ON INSERT RESTRICT ON UPDATE RESTRICT ON DELETE RESTRICT
);

-- Tabela Recept
CREATE TABLE Recept (
    idRecept INT NOT NULL CHECK (idRecept > 0),
    idDoktor INT NOT NULL CHECK (idDoktor > 0),
    idDete INT NOT NULL CHECK (idDete > 0),
    DatumIzavanja DATE NOT NULL,
    PRIMARY KEY (idRecept),
    FOREIGN KEY (idDoktor) REFERENCES Doktor(idDoktor) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (idDete) REFERENCES Dete(idDete) ON UPDATE CASCADE ON DELETE RESTRICT
);

-- Tabela StavkaRecepta
CREATE TABLE StavkaRecepta (
    idRecept INT NOT NULL CHECK (idRecept > 0),
    rb INT NOT NULL CHECK (rb > 0),
    idLek INT NOT NULL CHECK (idLek > 0),
    Terapija VARCHAR(255) NOT NULL,
    Zakljucak VARCHAR(255) NOT NULL,
    PRIMARY KEY (idRecept, rb),
    FOREIGN KEY (idRecept) REFERENCES Recept(idRecept) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (idLek) REFERENCES Lek(idLek) ON UPDATE CASCADE ON DELETE RESTRICT
);

-- Tabela DrSp
CREATE TABLE DrSp (
    idDoktor INT NOT NULL CHECK (idDoktor > 0),
    idSpecijalizacija INT NOT NULL CHECK (idSpecijalizacija > 0),
    PRIMARY KEY (idDoktor, idSpecijalizacija),
    FOREIGN KEY (idDoktor) REFERENCES Doktor(idDoktor) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (idSpecijalizacija) REFERENCES Specijalizacija(idSpecijalizacija) ON UPDATE CASCADE ON DELETE RESTRICT
);