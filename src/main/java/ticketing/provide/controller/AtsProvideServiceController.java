package ticketing.provide.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ticketing.provide.controller.service.AtsProvideService;

@RestController
public class AtsProvideServiceController {
	@Autowired
	AtsProvideService atsProvideService;

	public static final String OBJECT_KEY = "TICKETING.PAYLOAD";

	@Autowired
	@Qualifier("redisTemplate")
	private RedisTemplate<String, String> redisTemplate;

	@RequestMapping(value = "/{cannonicalIds}", method = RequestMethod.GET)
	public List processlayer(@PathVariable String cannonicalIds, ModelMap model) {

		List ticketingPalyloadList = new ArrayList();
		if (cannonicalIds != null) {
			String[] cannonicalArray = cannonicalIds.split(",");

			for (String cannonicalId : cannonicalArray) {
				String cacheData = (String) this.redisTemplate.opsForHash().get(OBJECT_KEY, cannonicalId);

				if (cacheData == null || cacheData.equals("")) {
					cacheData = atsProvideService.GetEvDetails(cannonicalId.trim());
					this.redisTemplate.opsForHash().put(OBJECT_KEY, cannonicalId, cacheData);
				}

				ticketingPalyloadList.add(cacheData);

			}

		}

		return ticketingPalyloadList;
	}

}
