package rs.cyrpto.test;

/**
 * Created by Ankush on 13-12-2022.
 */

import java.sql.Date;

import org.json.JSONException;
import org.json.JSONObject;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JwtGenerator
{
	
	
	private String JWTKey="YesSecurities";
	private long EXPIRATIONTIME=72000000;
	
	

	public String generate(JSONObject request)
	{

		try
		{
			Claims claims = Jwts.claims()
					.setSubject(request.getString("userName"));


			claims.put("pan", request.getString("pan"));
			claims.put("role", request.getString("role"));


//			 System.out.println("token time-----"+TOKEN_TIME);
			return Jwts.builder()
					.setClaims(claims)
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
					.signWith(SignatureAlgorithm.HS512, JWTKey)
					.compact();

		}
		catch (JSONException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	
	


}
