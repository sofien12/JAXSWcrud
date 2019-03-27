package WS;

import java.util.List;

import entity.Acount;
import javax.jws.*;
import entity.*;
import DAO.*;

@WebService(endpointInterface="WS.AcountWS")
public class AcountWSImpl implements AcountWS {

	public AcountWSImpl() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public List<Acount> findAll() {
		// TODO Auto-generated method stub
		AcountModel acountmodel = new AcountModel();
		return acountmodel.getAll();
	}

	@Override
	public void create(Acount act)   {
		// TODO Auto-generated method stub
		AcountModel acountmodel = new AcountModel();
		acountmodel.add(act);
	}

	@Override
	public void delete(Acount act) {
		// TODO Auto-generated method stub
		AcountModel acountmodel = new AcountModel();
		acountmodel.delete(act);
	}

	@Override
	public void update(Acount act) {
		// TODO Auto-generated method stub
		AcountModel acountmodel = new AcountModel();
		acountmodel.update(act);
		
	}

	

}
