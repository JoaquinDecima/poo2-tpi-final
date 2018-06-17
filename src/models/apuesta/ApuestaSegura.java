package models.apuesta;

class ApuestaSegura extends Apuesta {

	@Override
	float ganaciaBruta() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	float ganaciaNeta() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	float montoApostado() {
		return monto;
	}

	@Override
	OpcionApuesta opcionApostada() {
		// TODO Auto-generated method stub
		return null;
	}

	public void cancelarApuesta() {
		
	}
	
	public void reactivarApuesta() {
		
	}
	
}
