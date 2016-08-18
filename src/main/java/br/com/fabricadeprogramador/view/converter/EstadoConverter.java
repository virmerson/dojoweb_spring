package br.com.fabricadeprogramador.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fabricadeprogramador.model.Estado;
import br.com.fabricadeprogramador.repository.EstadoRepository;

@Component
public class EstadoConverter implements Converter {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			Estado estado= estadoRepository.findOne(new Integer(value));
			return estado;
		} catch (Exception e) {
			return null;
			//throw new ConverterException("Não pode converter " + value + " em estado!", e);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			Estado estado = (Estado) value;

			return estado.getId().toString();
		} catch (Exception e) {
			return null;
			//throw new ConverterException("Não pode converter " + value + " em String!", e);
		}
	}

}
