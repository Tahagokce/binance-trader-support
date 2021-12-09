package com.binance.trader.support.business.Impl;

import com.binance.trader.support.business.SelectedTokenService;
import com.binance.trader.support.business.UserService;
import com.binance.trader.support.models.entities.SelectedToken;
import com.binance.trader.support.models.entities.Symbol;
import com.binance.trader.support.models.entities.User;
import com.binance.trader.support.repository.SelectedTokenRepository;
import com.binance.trader.support.repository.SymbolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class SelectedTokenImpl implements SelectedTokenService {
    private final SymbolRepository symbolRepository;
    private final SelectedTokenRepository selectedTokenRepository;
    private final UserService userService;

    public SelectedToken addSelectedCoin (String symbol){
       User user = userService.findById(1).getData();
        Symbol result = symbolRepository.findBySymbolName(symbol);
        if (Objects.isNull(result)){
            throw new EntityNotFoundException();
        }
        SelectedToken selectedToken = new SelectedToken();
        selectedToken.setSymbol(result);
        selectedToken.setUser(user);

       return selectedTokenRepository.save(selectedToken);

    }

    public List<SelectedToken> getAllSelectedToken (User user){
       User result = userService.findById(user.getId()).getData();

       List<SelectedToken> selectedToken = selectedTokenRepository.findByUser(user);

       return selectedToken;
    }

    @Override
    public SelectedToken save(SelectedToken selectedToken) {
        return this.selectedTokenRepository.save(selectedToken);
    }
}
