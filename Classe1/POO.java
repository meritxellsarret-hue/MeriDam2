// RobotVEX
#include <iostream>
#include <string>
using namespace std;

class RobotVEX {
private:
    string nombre;
    int ruedas;
    int motores;
    int piston;
    int velocidad;

public:
    //Les variables per a que funcioni.
    RobotVEX(string n, int ru, int pi, int mo, int ve) {
        nombre = n;
        ruedas = ru;
        piston = pi;
        motores = mo;
        velocidad = ve;
    }
    //que fa el robot.
    void AgregarRueda(int num) {
        ruedas = ruedas + num;
        cout << "Ruedas agregadas: " << num << endl;
    }
    //
    void ActivarElevador(int motornum) {
        cout << "Elevador activado con el motor " << motornum << endl;
    }
    //
    void ActivarAutonoma() {
        cout << "Modo autónomo activado" << endl;
    }
    //
    bool Colision() {
        return false;
    }
};
// ....................................................................
int main() {
    // Crear el robot
    RobotVEX robot1("Robot", 4, 1, 2, 4);

    // Llamar a todas las funciones
    robot1.AgregarRueda(2);
    robot1.ActivarElevador(1);
    robot1.ActivarAutonoma();
    // Comprobar si hay una colisión
    if (robot1.Colision()) {
        cout << "Hay una colision" << endl;
    } else {
        cout << "No hay colision" << endl;
    }

    return 0;
}